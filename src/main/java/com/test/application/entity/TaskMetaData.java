/*
package com.test.application.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskMetaData {
    @Id
    private Integer taskMetaDataId;
    private Integer certificateNumber;
    private Integer lenderLoanNumber;
    private String originator;
    private String originatorOrgId;
    private String servicer;
    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "taskMetaDataId")
    private List<Task> task;

    public Integer getTaskMetaDataId() {
        return taskMetaDataId;
    }

    public void setTaskMetaDataId(Integer taskMetaDataId) {
        this.taskMetaDataId = taskMetaDataId;
    }

    public Integer getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(Integer certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Integer getLenderLoanNumber() {
        return lenderLoanNumber;
    }

    public void setLenderLoanNumber(Integer lenderLoanNumber) {
        this.lenderLoanNumber = lenderLoanNumber;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getOriginatorOrgId() {
        return originatorOrgId;
    }

    public void setOriginatorOrgId(String originatorOrgId) {
        this.originatorOrgId = originatorOrgId;
    }

    public String getServicer() {
        return servicer;
    }

    public void setServicer(String servicer) {
        this.servicer = servicer;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
}
*/
