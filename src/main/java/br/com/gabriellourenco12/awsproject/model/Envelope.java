package br.com.gabriellourenco12.awsproject.model;

import br.com.gabriellourenco12.awsproject.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Envelope {
    private EventType eventType;
    private String data;
}
