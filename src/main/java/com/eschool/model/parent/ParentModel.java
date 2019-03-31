package com.eschool.model.parent;

import com.eschool.domain.parent.Parent;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FatherModel.class, name = "father"),
        @JsonSubTypes.Type(value = MotherModel.class, name = "mother")})
@Getter
@Setter
@NoArgsConstructor
public abstract class ParentModel {

    private String name;
    private String cnic;
    private String occupation;
    private Double monthlySalary;
    private List<String> contactNumbers;
    private String address;

    public abstract Parent toParent();
}