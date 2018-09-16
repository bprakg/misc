package prakash.misc.jmhsample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

public class MyBenchmark {

	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.All)
	public void ootbBenchmark() {
		App.ootbParseInt();
	}
	
	@Fork(value = 1, warmups = 1)
	@Benchmark
	@BenchmarkMode(Mode.All)
	public void customBenchmark() {
		App.customParseInt();
	}
}
