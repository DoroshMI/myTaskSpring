package org.dorosh.spring.ch4;

import java.io.IOException;

public interface SimpleBeanInterface {
	

	public void setFilePath(String filePath);
	public void afterPropertiesSet() throws IOException;
	public void destroy();
	
}
