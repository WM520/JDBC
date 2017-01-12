package day2.jdbctemplate;

import java.util.List;

import com.donghui.smis.domian.Students;

public interface IStudentDAO {
	void save(Students stu) throws Exception;
	void delete(long i) throws Exception;
	void update(Students stu)  throws Exception;
	void get(int i) throws Exception;
	void get() throws Exception;
	
	List<Students> queryList() throws Exception;
}
