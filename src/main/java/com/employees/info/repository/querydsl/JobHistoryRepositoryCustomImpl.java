package com.employees.info.repository.querydsl;

import com.employees.info.dto.JobHistoryDto;
import com.employees.info.entity.JobHistory;
import com.employees.info.entity.QDepartments;
import com.employees.info.entity.QJobHistory;
import com.employees.info.entity.QJobs;
import com.employees.info.repository.JobHistoryRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class JobHistoryRepositoryCustomImpl extends QuerydslRepositorySupport
        implements JobHistoryRepositoryCustom {

    public JobHistoryRepositoryCustomImpl() {super(JobHistory.class);}

    QJobHistory jobHistory = QJobHistory.jobHistory;
    QJobs jobs = QJobs.jobs;
    QDepartments departments = QDepartments.departments;
    @Override
    public List<JobHistoryDto> getJobHistoryById(
            Long employeeId
    ) {
        return from(jobHistory)
                .select(Projections.constructor(
                        JobHistoryDto.class,
                        jobHistory.startDate,
                        jobHistory.endDate,
                        jobs.jobTitle,
                        departments.departmentName
                ))
                .join(jobs).on(jobHistory.jobId.eq(jobs.jobId))
                .join(departments).on(jobHistory.departmentId.eq(departments.departmentId))
                .where(
                        eqEmployeeId(employeeId)
                )
                .fetch();
    }

    private BooleanExpression eqEmployeeId(Long employeeId) {
        if (employeeId == null || employeeId == 0) {
            return null;
        }
        return jobHistory.employeeId.eq(employeeId);
    }

}
