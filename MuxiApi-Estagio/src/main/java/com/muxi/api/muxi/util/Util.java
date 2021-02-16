package com.muxi.api.muxi.util;




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

}
