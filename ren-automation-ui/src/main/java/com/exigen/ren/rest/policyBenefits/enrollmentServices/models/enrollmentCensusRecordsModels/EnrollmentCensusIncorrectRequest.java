package com.exigen.ren.rest.policyBenefits.enrollmentServices.models.enrollmentCensusRecordsModels;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "EnrollmentCensusRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnrollmentCensusIncorrectRequest extends Model {
    private FileMetaDataIncorrectModel fileMetaData;
    private EnrollmentCensusRecordsModel enrollmentCensusRecords;

    public FileMetaDataIncorrectModel getFileMetaData() {
        return fileMetaData;
    }

    public void setFileMetaData(FileMetaDataIncorrectModel fileMetaData) {
        this.fileMetaData = fileMetaData;
    }

    public EnrollmentCensusRecordsModel getEnrollmentCensusRecords() {
        return enrollmentCensusRecords;
    }

    public void setEnrollmentCensusRecords(EnrollmentCensusRecordsModel enrollmentCensusRecords) {
        this.enrollmentCensusRecords = enrollmentCensusRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        EnrollmentCensusIncorrectRequest that = (EnrollmentCensusIncorrectRequest) o;
        return Objects.equals(fileMetaData, that.fileMetaData) &&
                Objects.equals(enrollmentCensusRecords, that.enrollmentCensusRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fileMetaData, enrollmentCensusRecords);
    }
}
