package PatternInsert;



import pipeline.JedisClusterPipeline;
import redis.clients.jedis.RedisPipeline;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface CsvImportOperation {

    CsvImportOperation SET = new AbstractCsvImportOperation("SET") {
        @Override
        public void importCsvLine(JedisClusterPipeline redisPipeline, Csvline csvline) {
            redisPipeline.set(csvline.getKey(),csvline.getValue());
            redisPipeline.sync();
        }
    };

    CsvImportOperation HSET = new AbstractCsvImportOperation("HSET") {
        @Override
        public void importCsvLine(JedisClusterPipeline redisPipeline, Csvline csvline) {
            redisPipeline.hset(csvline.getKey(),csvline.getField(),csvline.getValue());
            redisPipeline.sync();
        }
    };

    CsvImportOperation ZADD = new AbstractCsvImportOperation("ZADD") {
        @Override
        public void importCsvLine(JedisClusterPipeline redisPipeline, Csvline csvline) {
            redisPipeline.zadd(csvline.getKey(),Double.parseDouble(csvline.getField()),csvline.getValue());
            redisPipeline.sync();
        }
    };


    Map<String, CsvImportOperation> OPERATIONS  = Stream.of(SET,HSET,ZADD).collect(Collectors.toMap(CsvImportOperation::getName, Function.identity()));


    void importCsvLine(JedisClusterPipeline redisPipeline, Csvline csvline);


    String getName();

    abstract class AbstractCsvImportOperation implements CsvImportOperation {
        protected final String name;
        public AbstractCsvImportOperation(String name) {
            this.name = name;
        }
        @Override
        public String getName(){
            return name;
        }


    }


}
