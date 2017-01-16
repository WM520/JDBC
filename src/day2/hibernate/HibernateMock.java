package day2.hibernate;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import day2.jdbctemplate.JdbcTemplate;
import day2.jdbctemplate.Students;
import day2.jdbctemplate.Table;



// 模拟hibernate
public class HibernateMock {
	public static void save(Object obj) {
		try {
			// 获取对象对应的表名
			String tableName = "";
			Table table = obj.getClass().getAnnotation(Table.class);
			if (table != null) {
				tableName = table.value();
			}
			// insert into login (user, password) values (?,?)
			StringBuilder sql = new StringBuilder();
			sql.append("insert into ").append(tableName).append(" (");
			
			
			StringBuilder propertySql = new StringBuilder();
			StringBuilder placeSql = new StringBuilder();
			// 定义一个集合数组
			List<Object> params = new ArrayList<>();
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(), Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				String propertyName = pd.getName();
				
				if (!"id".equals(propertyName)) {
					propertySql.append(propertyName).append(",");
					placeSql.append("?").append(",");
					Object val = pd.getReadMethod().invoke(obj);
					params.add(val);
				}
				
			}
			propertySql.deleteCharAt(propertySql.length() - 1);
			placeSql.deleteCharAt(placeSql.length() - 1);
			sql.append(propertySql);
			sql.append(")").append(" values (");
			sql.append(placeSql);
			sql.append(")");
			
			System.out.println(sql);
			System.out.println(params);
			JdbcTemplate.update(sql.toString(), params.toArray());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Students stu = new Students("wangmiao", "24");
		HibernateMock.save(stu);
	}
}
