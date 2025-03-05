package entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryEntity {

    private String nome;
    private String descricao;
    private List<BookEntity> books =  new ArrayList<>();


}
