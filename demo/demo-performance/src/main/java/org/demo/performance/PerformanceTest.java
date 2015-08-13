/*
 * Copyright 2002-2101 SIM group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.demo.performance;

import java.util.Random;

import com.github.jobop.performance.spi.PerformanceBizSpi;
import com.github.jobop.performance.task.PerformanceTask;

/**
 * 
 * @CreateTime 2015年7月14日 下午7:46:32
 * 
 * @author chao.yu
 *
 * @version 1.0
 *
 */
public class PerformanceTest implements PerformanceBizSpi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new PerformanceTask().t(1).c(1l).l("test.log")
				.addTest(new PerformanceTest()).start();
	}

	@Override
	public boolean execute() {
		System.out.println("模拟50%成功率");
		return (new Random().nextInt(10) % 2) == 0;
	}

	/**
	 * java 性能测试框架
	 * https://github.com/jobop/performance
	 * 
	 * 
	 */
}
