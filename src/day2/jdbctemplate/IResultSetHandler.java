package day2.jdbctemplate;

import java.sql.ResultSet;
import java.util.List;

public interface IResultSetHandler<T> {
	List<T> handle(ResultSet rs) throws Exception;
}
