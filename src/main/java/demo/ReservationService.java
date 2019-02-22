package demo;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ReservationService extends Service<ReservationConfiguration> {
    public static void main(String[] args) throws Exception {
        new ReservationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ReservationConfiguration> bootstrap) {
        bootstrap.setName("reservation-system");
    }

    @Override
    public void run(ReservationConfiguration configuration, Environment environment) throws Exception {
        environment.addResource(new BookingResource());
    }
}
