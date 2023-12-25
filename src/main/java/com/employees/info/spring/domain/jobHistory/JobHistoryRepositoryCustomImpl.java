package com.employees.info.spring.domain.jobHistory;

import com.employees.info.spring.api.controller.employees.dto.JobHistoryDto;
import com.employees.info.spring.domain.departments.QDepartments;
import com.employees.info.spring.domain.jobHistory.QJobHistory;
import com.employees.info.spring.domain.jobs.QJobs;
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
