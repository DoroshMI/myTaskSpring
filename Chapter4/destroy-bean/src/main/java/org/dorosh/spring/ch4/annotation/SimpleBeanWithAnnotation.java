package org.dorosh.spring.ch4.annotation;

import org.dorosh.spring.ch4.SimpleBeanInterface;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.File;

public class SimpleBeanWithAnnotation implements SimpleBeanInterface {

	private String filePath;
	private File file;

	@Override
	public void setFilePath(String filePath){
		this.filePath=filePath;
	}

	@Override
	@PostConstruct
	public void afterPropertiesSet() throws IOException{
		System.out.println("Initializing Bean in "+SimpleBeanWithAnnotation.class);

		if(filePath==null) {
			throw new IllegalArgumentException("You must set the filePath property of any beans of type"+
				SimpleBeanWithAnnotation.class);
		}

		this.file=new File(filePath);
		this.file.createNewFile();
		System.out.println("File exists: "+file.exists());
	}

	@Override
	public void destroy(){
		System.out.println("Destroing Bean in "+SimpleBeanWithAnnotation.class);
		if(!file.delete()){
			System.err.println("ERROR: failed to delete file.");
		}
		System.out.println("File exists: "+file.exists());
	}
	
}
