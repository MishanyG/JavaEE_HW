package HomeWork_4;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private Long id;
    @NotNull(message = "Поле не должно быть пустым")
    @Size (min = 3, max = 45,message = "Поле должно содержать от 3 до 45 символов")
    private String firm;
    @NotNull(message = "Поле не должно быть пустым")
    @Size (min = 3, max = 45,message = "Поле должно содержать от 3 до 45 символов")
    private String model;
    @NotNull(message = "Поле не должно быть пустым")
    private BigDecimal price;

    public Product (Long id, String firm, String model, BigDecimal price) {
        this.id = id;
        this.firm = firm;
        this.model = model;
        this.price = price;
    }

    public Product () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getFirm () {
        return firm;
    }

    public void setFirm (String firm) {
        this.firm = firm;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal price) {
        this.price = price;
    }
}
