package com.loonycorn.SpringDataJDBC;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("DesignationDetails")
public class DesignationDetails {
    @Id
    @Column("designationId")
    private Long designationId;

    @Column("designationName")
    private String designationName;

    public DesignationDetails(final Long designationId, final String designationName) {
        this.designationId = designationId;
        this.designationName = designationName;
    }

    static DesignationDetails addDesignation(Long designationId, String designationName) {
        return new DesignationDetails(designationId, designationName);
    }

    @Override
    public String toString() {
        return "DesignationDetails{" +
                "designationId=" + designationId +
                ", designationName='" + designationName + '\'' +
                '}';
    }
}
