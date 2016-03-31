package classes;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column (name = "id")
    private long id;


    @Column (name = "amount")
    private String amount;

    @Column (name = "idproduct")
    private long idproduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="login")
    private Users users;
}
