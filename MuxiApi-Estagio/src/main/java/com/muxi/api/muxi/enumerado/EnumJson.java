package com.muxi.api.muxi.enumerado;

public enum EnumJson {

	SCHEMA (
			"{\r\n" + 
					"	\"title\": \"Terminal\",\r\n" + 
					"	\"type\": \"object\",\r\n" + 
					"	\"properties\": {\r\n" + 
					"		\"logic\": {\r\n" + 
					"			\"type\": \"integer\"\r\n" + 
					"		},\r\n" + 
					"		\"serial\": {\r\n" + 
					"			\"type\": \"string\"\r\n" + 
					"		},\r\n" + 
					"		\"sam\": {\r\n" + 
					"			\"type\": \"integer\",\r\n" + 
					"			\"minimum\": 0\r\n" + 
					"		},\r\n" + 
					"		\"ptid\": {\r\n" + 
					"			\"type\": \"string\"\r\n" + 
					"		},\r\n" + 
					"		\"plat\": {\r\n" + 
					"			\"type\": \"integer\"\r\n" + 
					"		},\r\n" + 
					"		\"version\": {\r\n" + 
					"			\"type\": \"string\"\r\n" + 
					"		},\r\n" + 
					"		\"mxr\": {\r\n" + 
					"			\"type\": \"integer\"\r\n" + 
					"		},\r\n" + 
					"		\"VERFM\": {\r\n" + 
					"			\"type\": \"string\"\r\n" + 
					"		}\r\n" + 
					"	},\r\n" + 
					"	\"required\": [\r\n" + 
					"		\"logic\",\r\n" + 
					"		\"serial\",\r\n" + 
					"		\"model\",\r\n" + 
					"		\"version\"\r\n" + 
					"	]\r\n" + 
					"}\r\n" + 
			"");
	
	private String schema;
	EnumJson(String schema) {
		this.schema = schema;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
}
