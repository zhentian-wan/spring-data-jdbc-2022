package com.loonycorn.SpringDataJDBC;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("TechnologyDetails")
public class TechnologyDetails {
    @Id
    @Column("technologyId")
    private Long technologyId;

    @Column("technologyName")
    private String technologyName;

    public TechnologyDetails(final Long technologyId, final String technologyName) {
        this.technologyId = technologyId;
        this.technologyName = technologyName;
    }

    public Long getTechnologyId() {
        return technologyId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyId(final Long technologyId) {
        this.technologyId = technologyId;
    }

    public void setTechnologyName(final String technologyName) {
        this.technologyName = technologyName;
    }

    static TechnologyDetails addTech(Long technologyId, String technologyName) {
        return new TechnologyDetails(technologyId, technologyName);
    }

    @Override
    public String toString() {
        return "TechnologyDetails{" +
                "technologyId=" + technologyId +
                ", technologyName='" + technologyName + '\'' +
                '}';
    }
}
