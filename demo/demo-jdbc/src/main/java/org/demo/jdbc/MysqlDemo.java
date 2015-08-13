/*
 * Copyright 2002-2101 SIM group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 * 
 * @CreateTime 2015年7月16日 下午5:40:48
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class MysqlDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://172.19.2.7:3306/cat";
		String user = "root";
		String pass = ".";
		Connection conn = DriverManager.getConnection(url, user, pass);

		String sql = "select * from abtest";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs= ps.executeQuery();
		
		ResultSetMetaData rsm =rs.getMetaData();
		
		System.out.println(rsm.getColumnCount());
		//下标从“1”开始
		System.out.println(rsm.getTableName(1));
		System.out.println(rsm.getColumnName(1));
		System.out.println(rsm.getColumnType(1));
		System.out.println(rsm.getColumnTypeName(1));
				

		conn.close();
	}

}
