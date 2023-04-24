package com.rupesh.dwiz;

import com.rupesh.dwiz.core.Constants;
import com.rupesh.dwiz.health.TemplateHealthCheck;
import com.rupesh.dwiz.resources.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DwizAppApplication extends Application<DwizAppConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(DwizAppApplication.class);

    private static final String NOTARY_APPLICATION = "notaryApplication";
    private final boolean notaryApplication;
    private final boolean ageApplication;

    public DwizAppApplication(boolean notaryApplication, boolean ageApplication) {
        this.notaryApplication = notaryApplication;
        this.ageApplication = ageApplication;
    }

    public static void main(final String[] args) throws Exception {


        String value = System.getProperty(NOTARY_APPLICATION);
        Boolean notaryApplication = value != null && value.equalsIgnoreCase("true");
        logger.info(String.format("######Is Notary Application: %s", value));

        new DwizAppApplication(notaryApplication, true).run(args);
    }

    @Override
    public String getName() {
        return "dwizApp";
    }



    @Override
    public void initialize(final Bootstrap<DwizAppConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DwizAppConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application



        String applicationContextPath = configuration.getApplicationContextPath();
        if (applicationContextPath == null || applicationContextPath.isEmpty()) {
            applicationContextPath = Constants.DEFAULT_APPLICATION_CONTEXT_PATH;

        }

        environment.getApplicationContext().setContextPath(applicationContextPath);

        final DwizAppResource resource = new DwizAppResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final DwizSayAge ageResource = new DwizSayAge(
                configuration.getAge(),
                configuration.getAgeString()
        );

        final EmployeeResource employeeResource = new EmployeeResource();
        final EmployeeResource2 employeeResource2 = new EmployeeResource2();

        final NotaryValidateResource notaryResource = new NotaryValidateResource();


        final TemplateHealthCheck healthCheck = new TemplateHealthCheck( configuration.getTemplate() );




        environment.healthChecks().register( "template" , healthCheck );
        environment.jersey().register( resource );
        environment.jersey().register( ageResource );
        environment.jersey().register(employeeResource2);
        environment.jersey().register(notaryResource);


        if ( notaryApplication ) {
            String notaryContextPath = configuration.getApplicationContextPath();
            if (notaryContextPath == null || applicationContextPath.isEmpty()) {
                notaryContextPath = Constants.NOTARY_APPLICATION_CONTEXT_PATH;

            }
            environment.getApplicationContext().setContextPath(notaryContextPath);
            environment.jersey().register( employeeResource );
        }




    }



}
