package com.muxi.api.muxi.util;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.util.JsonLoader;

public class Util {

	public boolean validateSchema(String Json, String Schema) {

		try {
			JsonNode schemaNode = JsonLoader.fromString(Schema);
			JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
			JsonSchema schema = factory.getJsonSchema(schemaNode);
			JsonNode dataNode = JsonLoader.fromString(Json);
			ProcessingReport report = schema.validate(dataNode);
			return report.isSuccess();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public JSONObject stringToJson(String[] array) {

		JSONObject obj = new JSONObject();
		obj.put("logic", Integer.parseInt(array[0]));
		obj.put("serial", array[1]);
		obj.put("model", array[2]);
		obj.put("sam", Integer.parseInt(array[3]));
		obj.put("ptid", array[4]);
		obj.put("plat", Integer.parseInt(array[5]));
		obj.put("version", array[6]);
		obj.put("mxr", Integer.parseInt(array[7]));
		obj.put("mxf", array[8]);
		if (array.length == 10) {
			obj.put("verfm", array[9]);
		}

		return obj;
	}

}
