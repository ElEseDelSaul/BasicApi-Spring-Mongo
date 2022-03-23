package sm.apirest.tareas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data   //Precargar Getters y Setters del modelo
@Document
public class Tarea {

    @Id
    private String id;
    private String nombre;
    private Boolean status;

}
