package expert.os.jakarta.data.nosql;


import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public class Book {


    @Id
    private String isbn;

    @Column
    private String title;

    @Column
    private int edition;
}
