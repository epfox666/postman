package epfox.test2;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.*;
public class V2exAPITest2 {
	
	@Test
	public void nodeApi() throws IOException{
	OkHttpClient client = new OkHttpClient();
	String[] nodeName= {"php","python","qna"};
	for(int i=0;i<nodeName.length;i++) {
	Request request = new Request.Builder()
	  .url("https://www.v2ex.com/api/nodes/show.json?name="+nodeName[i])
	  .get()
	  .build();
	Response response = client.newCall(request).execute();
	V2exNode node=JSON.parseObject(response.body().string(),V2exNode.class);
	assertEquals(node.getName(), nodeName[i]);

   }
 }
}
