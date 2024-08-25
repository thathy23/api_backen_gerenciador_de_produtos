package br.com.gerenciadordeprodutos.api.model;
import br.com.gerenciadordeprodutos.api.enums.TipoFornecedorEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "fornecedor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pra gerar id em sequencia
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cnpj", nullable = false, unique = true, length = 15)
    private String CNPJ;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)// para ficar string e nao o padrao 1 e 0 que ta no enumpor padrao
    @Column(name= "tipo_fornecedor", nullable = false)//nome padrao snack case do banco de dados
    private TipoFornecedorEnum tipoFornecedor;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @Column(name ="atualizado_em", nullable = false)
    private LocalDateTime atualizadoEm;

}
