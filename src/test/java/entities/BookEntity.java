package entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookEntity {

    private String titulo;
    private String nomeAutor;
    private String texto;

}
