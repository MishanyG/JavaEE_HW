package HomeWork_4;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;

public class Category implements Serializable {

    private Long category_id;
    @NotNull(message = "Поле не должно быть пустым")
    @Size (min = 3, max = 75, message = "Поле должно содержать от 3 до 75 символов")
    private String category;

    public Category (Long category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }

    public Category () {
    }

    public Long getCategory_id () {
        return category_id;
    }

    public void setCategory_id (Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory () {
        return category;
    }

    public void setCategory (String category) {
        this.category = category;
    }
}
