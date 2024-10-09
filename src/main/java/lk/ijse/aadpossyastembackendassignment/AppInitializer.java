package lk.ijse.aadpossyastembackendassignment;


import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import lk.ijse.aadpossyastembackendassignment.config.WebAppConfig;
import lk.ijse.aadpossyastembackendassignment.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
        @Override
        protected Class<?>[] getRootConfigClasses() {
            AbandonedConnectionCleanupThread.checkedShutdown();

            return new Class[]{WebAppRootConfig.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[]{WebAppConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }

        @Override
        protected void customizeRegistration(ServletRegistration.Dynamic registration) {
            String tempDir = System.getProperty("java.io.tmpdir");
            registration.setMultipartConfig(new MultipartConfigElement(tempDir));
        }
}