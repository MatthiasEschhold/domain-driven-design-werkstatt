package architecture.fitness.check;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import de.novatec.clean.architecture.fitness.functions.CleanArchitecturePackageAccessConfiguration;
import de.novatec.clean.architecture.fitness.functions.CleanArchitectureTwoWayMappingStrategyCheck;

import java.util.List;

@AnalyzeClasses(packages = "de.novatec.autohaus.werkstatt.werkstattplanung")
public class CleanArchitectureFitnessCheck {

    @ArchTest
    void should_check_clean_architecture_structrual_fitness(JavaClasses javaClasses) {
        CleanArchitecturePackageAccessConfiguration cleanArchitecturePackageAccessConfiguration = new CleanArchitecturePackageAccessConfiguration();
        cleanArchitecturePackageAccessConfiguration.withAllowedAapterOutAccessForEventDrivenApporach(
                List.of("..werkstatt.werkstattplanung.werkstattauftrag.adapter.out.event..", "..werkstatt.werkstattplanung.werkstattplan.adapter.out.event.."));
        cleanArchitecturePackageAccessConfiguration.withFameworkAndLibraries(List.of("..java..", "..org.."));
        cleanArchitecturePackageAccessConfiguration.withDomainSharedKernel(List.of("..werkstatt.common.exception.."));

        CleanArchitectureTwoWayMappingStrategyCheck cleanArchitectureTwoWayMappingStrategyCheck = new CleanArchitectureTwoWayMappingStrategyCheck();
        cleanArchitectureTwoWayMappingStrategyCheck.runFitnessCheck(javaClasses, cleanArchitecturePackageAccessConfiguration);
    }
}
