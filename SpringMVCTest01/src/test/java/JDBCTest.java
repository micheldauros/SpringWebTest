import com.yy.sakila.mapper.ActorMapper;
import com.yy.sakila.mapper.AddressMapper;
import com.yy.sakila.mapper.UnspecificMapper;
import com.yy.sakila.pojo.Actor;
import com.yy.sakila.vo.JDBCTestEmbeddedSimpleVO;
import com.yy.sakila.vo.JDBCTestEmbeddedVO;
import com.yy.sakila.vo.JDBCTestVO;
import com.yy.utils.MybatisUtil;
import com.yy.utils.MysqlInit;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.sql.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JDBCTest {
    @Test
    public void test01() throws SQLException {
        List<JDBCTestVO> jdbcTestVOList = new ArrayList<>();
        Connection connection = MysqlInit.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select sakila.film.film_id,sakila.film.replacement_cost, sakila.film.title,sakila.film.description,sakila.film.length, i.inventory_id,i.store_id, fc.category_id,fa.actor_id\n" +
                "from (((sakila.film left join sakila.inventory i on film.film_id = i.film_id) left join sakila.film_category fc on film.film_id=fc.film_id) left join sakila.film_actor fa on film.film_id=fa.film_id)");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            JDBCTestVO jdbcTestVO = new JDBCTestVO();
            jdbcTestVO.setFilmId(resultSet.getInt("film_id"));
            jdbcTestVO.setTitle(resultSet.getString("title"));
            jdbcTestVO.setLength(resultSet.getInt("length"));
            jdbcTestVO.setReplacementCost(resultSet.getBigDecimal("replacement_cost"));
            jdbcTestVO.setInventoryId(resultSet.getInt("inventory_id"));
            jdbcTestVO.setStoreId(resultSet.getInt("store_id"));
            jdbcTestVO.setCategoryId(resultSet.getInt("category_id"));
            jdbcTestVO.setActorId(resultSet.getInt("actor_id"));
            jdbcTestVOList.add(jdbcTestVO);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        System.out.println(jdbcTestVOList.stream().count());
    }

//    @Test
//    public void test02() throws SQLException {
//        List<JDBCTestEmbeddedVO> jdbcTestEmbeddedVOList = new ArrayList<>();
//        Connection connection = MysqlInit.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("select sakila.film.film_id,sakila.film.replacement_cost, sakila.film.title,sakila.film.description,sakila.film.length, i.inventory_id,i.store_id, fc.category_id,fa.actor_id, fa.last_update\n" +
//                "from (((sakila.film left join sakila.inventory i on film.film_id = i.film_id) left join sakila.film_category fc on film.film_id=fc.film_id) left join sakila.film_actor fa on film.film_id=fa.film_id)");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            JDBCTestEmbeddedVO jdbcTestEmbeddedVO = new JDBCTestEmbeddedVO();
//            jdbcTestEmbeddedVO.setFilmId(resultSet.getInt("film_id"));
//            jdbcTestEmbeddedVO.setTitle(resultSet.getString("title"));
//            jdbcTestEmbeddedVO.setLength(resultSet.getInt("length"));
//            jdbcTestEmbeddedVO.setReplacementCost(resultSet.getBigDecimal("replacement_cost"));
//            jdbcTestEmbeddedVO.setInventoryId(resultSet.getInt("inventory_id"));
//            jdbcTestEmbeddedVO.setStoreId(resultSet.getInt("store_id"));
//            jdbcTestEmbeddedVO.setCategoryId(resultSet.getInt("category_id"));
//            jdbcTestEmbeddedVO.setActors(actors);
//            jdbcTestEmbeddedVOList.add(jdbcTestEmbeddedVO);
//        }
//        resultSet.close();
//        preparedStatement.close();
//        connection.close();
//        System.out.println(jdbcTestVOList.stream().count());
//    }

    @Test
    //此测试在业务上通常不可行，因为新建对象太多，可能会严重降低性能
    public void test03() throws SQLException {
        ZoneId zoneId= ZoneId.systemDefault();
        ArrayList<JDBCTestEmbeddedSimpleVO> jdbcTestEmbeddedSimpleVOS=new ArrayList<>();
        Connection connection = MysqlInit.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select group_concat(sakila.film_actor.actor_id) actorList,sakila.film_actor.film_id filmId from sakila.film_actor group by sakila.film_actor.film_id;");
        PreparedStatement preparedStatementSub=connection.prepareStatement("select sakila.actor.actor_id,sakila.actor.first_name,sakila.actor.last_name,sakila.actor.last_update from sakila.actor where sakila.actor.actor_id=(?)");
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSet resultSetSub=null;
        while (resultSet.next()){
            ArrayList<Actor> actors=new ArrayList<Actor>();
            JDBCTestEmbeddedSimpleVO jdbcTestEmbeddedSimpleVO=new JDBCTestEmbeddedSimpleVO();
            String actorListString=resultSet.getString("actorList");
            String[] actorIdList=actorListString.split(",");
            for(String s:actorIdList){
                Actor actor=new Actor();
                Integer value=Integer.valueOf(s);
                preparedStatementSub.setInt(1,value);
                resultSetSub = preparedStatementSub.executeQuery();
                while(resultSetSub.next()){
                    actor.setActor_id(resultSetSub.getInt("actor_id"));
                    actor.setFirstName(resultSetSub.getString("first_name"));
                    actor.setLastName(resultSetSub.getString("last_name"));
                    actor.setLastUpdate(resultSetSub.getTimestamp("last_update").toLocalDateTime());
                    actors.add(actor);
                }
            }
            jdbcTestEmbeddedSimpleVO.setActors(actors);
            jdbcTestEmbeddedSimpleVO.setFilmId(resultSet.getInt("filmId"));
            jdbcTestEmbeddedSimpleVOS.add(jdbcTestEmbeddedSimpleVO);


        }
        resultSetSub.close();
        preparedStatementSub.close();
        resultSet.close();
        preparedStatement.close();
        connection.close();
        System.out.println(jdbcTestEmbeddedSimpleVOS.get(1));
    }
    @Test
    //此测试在业务上通常不可行，因为新建对象太多，可能会严重降低性能
    public void test04() throws SQLException {
        ZoneId zoneId= ZoneId.systemDefault();
        ArrayList<JDBCTestEmbeddedSimpleVO> jdbcTestEmbeddedSimpleVOS=new ArrayList<>();
        Connection connection = MysqlInit.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select sakila.actor.actor_id,sakila.actor.last_name,sakila.actor.first_name,sakila.actor.last_update,sakila.film_actor.film_id from sakila.film_actor inner join sakila.actor  on film_actor.actor_id = actor.actor_id order by sakila.film_actor.film_id;");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            JDBCTestEmbeddedSimpleVO jdbcTestEmbeddedSimpleVO=new JDBCTestEmbeddedSimpleVO();
            jdbcTestEmbeddedSimpleVO.setFilmId(resultSet.getInt("film_id"));
            //# TODO
            //resultSet.
        }
    }
    @Test
    public void test05(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        ActorMapper actorMapper=sqlSession.getMapper(ActorMapper.class);
        for(Actor actor:actorMapper.selectAll()){
            System.out.println(actor);
        }
        sqlSession.close();
    }

    @Test
    public void test06(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        UnspecificMapper unspecificMapper=sqlSession.getMapper(UnspecificMapper.class);
        JDBCTestEmbeddedSimpleVO jdbcTestEmbeddedSimpleVO=unspecificMapper.getFilmActor(3);
        System.out.println(jdbcTestEmbeddedSimpleVO);
    }

    @Test
    public void test07(){
        System.out.println("这是中文编码");
    }

    @Test
    public void test08(){
        Jedis jedis=new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        System.out.println(jedis.get("fields *"));
        final Transaction multi = jedis.multi();
        jedis.close();

    }

    @Test
    public void test09(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        String location = mapper.getLocationById(3);
        System.out.println(location);
    }
}
