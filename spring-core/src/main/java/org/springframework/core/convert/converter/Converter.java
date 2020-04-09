/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.convert.converter;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.lang.Nullable;

/**
 * A converter converts a source object of type {@code S} to a target of type {@code T}.
 *
 * <p>Implementations of this interface are thread-safe and can be shared.
 *
 * <p>Implementations may additionally implement {@link ConditionalConverter}.
 *
 * @author Keith Donald
 * @since 3.0
 * @param <S> the source type
 * @param <T> the target type
 *
 * 扩展点之十七：Converter-类型转换器，要将这些转换器 添加到ConversionService中去，成为转换服务中转换链的一员
 * 客户端使用实例
 * <pre class="code">
 *    package xxx.xxx.xxx;
 *
 *    public class ClientDemo {
 *        public static void main(){
 *           DefaultConversionService conversionService = new DefaultConversionService();
 *           conversionService.addConverter(我们自定义的继承了Converter接口的转换器类);
 *           String source = "要进行转换的字符串";
 *           conversionService.convert(source,"要转成的类型的Class文件");
 *        }
 *    }
 *  </pre>
 */
@FunctionalInterface
public interface Converter<S, T> {

	/**
	 * Convert the source object of type {@code S} to target type {@code T}.
	 * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
	 * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
	 * @throws IllegalArgumentException if the source cannot be converted to the desired target type
	 */
	@Nullable
	T convert(S source);

}
