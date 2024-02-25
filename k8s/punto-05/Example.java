import java.util.List;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

public class Example {
   /**
    * @param args
    */
   public static void main(String[] args) {
      KubernetesClient client = new KubernetesClientBuilder().build();
      
      final List<Pod> pods = client.pods().inNamespace("name1").list().getItems();
      pods.forEach(p -> {
         System.out.println(p.getMetadata().getName());
         p.isMarkedForDeletion();
      });
      
      client.close();

      // while (true) {}
   }

}