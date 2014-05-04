package org.treasureboat.eoaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TBJDBCModel extends TBModel {

	private static final String JDBC_DRIVER = "javax.persistence.jdbc.driver";
	private static final String JDBC_URL = "javax.persistence.jdbc.driver";
	private static final String USER = "javax.persistence.jdbc.user";
	private static final String PASSWORD = "javax.persistence.jdbc.password";

	private String driver;
	private String url;
	private String user;
	private String password;

	public TBJDBCModel(String name, TransactionType transactionType) {
		super(name, transactionType);
	}

	public TBJDBCModel(String name) {
		super(name);
	}

	public void load(String path) {
		if (path == null) {
			String message = "Invalid eomodeld folder [" + path + "]";
			throw new IllegalArgumentException(message);
		}
		load(new File(path));
	}

	public void load(File folder) {
		if (folder == null || !folder.exists() || !folder.isDirectory()) {
			String message = "Invalid eomodeld folder [" + folder + "]";
			throw new IllegalArgumentException(message);
		}
		File indexFile = new File(folder, "index.eomodeld");
		try {
			String content = loadPlist(indexFile);
			System.out.println(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String loadPlist(String path) throws IOException {
		if (path == null) {
			String message = "Cannot load plist from path [" + path + "]";
			throw new IllegalArgumentException(message);
		}
		return loadPlist(new File(path));
	}

	public String loadPlist(File file) throws IOException {
		if (file == null || !file.exists()) {
			String message = "Cannot load plist from file [" + file + "]";
			throw new IllegalArgumentException(message);
		}
		return loadPlist(new FileInputStream(file));
	}

	public String loadPlist(InputStream inputStream) throws IOException {
		if (inputStream == null) {
			String message = "Cannot load plist from stream [" + inputStream + "]";
			throw new IllegalStateException(message);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		try {
			String line = br.readLine();
			StringBuilder sb = new StringBuilder();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
		TBJDBCModel model = new TBJDBCModel("Peripheral");
		model.load("/Users/fijaz/git-repos/Fuego/FDFrameworks/trunk/FDCore/Resources/Peripheral.eomodeld");
	}
}
