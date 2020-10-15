package ds.galleryclient.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExhibitionPayload {
    private String name;
    private int open;

}
