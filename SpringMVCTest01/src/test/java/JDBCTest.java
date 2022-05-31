import com.yy.sakila.vo.JDBCTestEmbeddedVO;
import com.yy.sakila.vo.JDBCTestVO;
import com.yy.utils.MysqlInit;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test02() throws SQLException {
        List<JDBCTestEmbeddedVO> jdbcTestEmbeddedVOList = new ArrayList<>();
        Connection connection = MysqlInit.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select sakila.film.film_id,sakila.film.replacement_cost, sakila.film.title,sakila.film.description,sakila.film.length, i.inventory_id,i.store_id, fc.category_id,fa.actor_id, fa.last_update\n" +
                "from (((sakila.film left join sakila.inventory i on film.film_id = i.film_id) left join sakila.film_category fc on film.film_id=fc.film_id) left join sakila.film_actor fa on film.film_id=fa.film_id)");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            JDBCTestEmbeddedVO jdbcTestEmbeddedVO = new JDBCTestEmbeddedVO();
            jdbcTestEmbeddedVO.setFilmId(resultSet.getInt("film_id"));
            jdbcTestEmbeddedVO.setTitle(resultSet.getString("title"));
            jdbcTestEmbeddedVO.setLength(resultSet.getInt("length"));
            jdbcTestEmbeddedVO.setReplacementCost(resultSet.getBigDecimal("replacement_cost"));
            jdbcTestEmbeddedVO.setInventoryId(resultSet.getInt("inventory_id"));
            jdbcTestEmbeddedVO.setStoreId(resultSet.getInt("store_id"));
            jdbcTestEmbeddedVO.setCategoryId(resultSet.getInt("category_id"));
            jdbcTestEmbeddedVO.setFilmActors(filmActors);
            jdbcTestEmbeddedVOList.add(jdbcTestEmbeddedVO);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        System.out.println(jdbcTestVOList.stream().count());
    }
}
