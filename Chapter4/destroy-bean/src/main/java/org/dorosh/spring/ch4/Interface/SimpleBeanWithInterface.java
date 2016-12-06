package org.dorosh.spring.ch4.Interface;

import org.dorosh.spring.ch4.SimpleBeanInterface;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import java.io.IOException;
import java.io.File;

public class SimpleBeanWithInterface implements SimpleBeanInterface, InitializingBean, DisposableBean {

	private String filePath;
	private File file;

	@Override
	public void setFilePath(String filePath){
		this.filePath=filePath;
	}

	@Override
	public void afterPropertiesSet() throws IOException{
		System.out.println("Initializing Bean in "+SimpleBeanWithInterface.class);

		if(filePath==null) {
			throw new IllegalArgumentException("You must set the filePath property of any beans of type"+
				SimpleBeanWithInterface.class);
		}

		this.file=new File(filePath);
		this.file.createNewFile();
		System.out.println("File exists: "+file.exists());
	}

	@Override
	public void destroy(){
		System.out.println("Destroing Bean in "+SimpleBeanWithInterface.class);
		if(!file.delete()){
			System.err.println("ERROR: failed to delete file.");
		}
		System.out.println("File exists: "+file.exists());
	}
	
}
