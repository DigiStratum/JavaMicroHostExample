package com.digistratum.microhost.Example.Model;

import com.digistratum.Database.Exception.MHDatabaseException;
import com.digistratum.Database.Mysql.Connection.MySqlConnection;
import com.digistratum.Database.Mysql.Model.MysqlModelImpl;

import java.util.List;

public class ModelMysqlDatabaseImpl extends MysqlModelImpl {
	public String Database;

	public ModelMysqlDatabaseImpl() {
		super();
	}

	/**
	 * Get a list of databases from our database server connection
	 *
	 * @return List of ModelMysqlDatabaseImpl's
	 *
	 * @throws MHDatabaseException for any errors
	 */
	public List<ModelMysqlDatabaseImpl> getDatabases(MySqlConnection conn) throws MHDatabaseException {
		return conn.query(
			ModelMysqlDatabaseImpl.class,
			"show databases;"
		);
	}
}
