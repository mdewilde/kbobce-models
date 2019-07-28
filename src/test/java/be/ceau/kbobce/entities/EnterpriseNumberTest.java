/*
	Copyright 2019 Marceau Dewilde <m@ceau.be>
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		https://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package be.ceau.kbobce.entities;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class EnterpriseNumberTest {

	@Test
	public void isValidTest() throws IOException, URISyntaxException {
		Files.lines(Paths.get(getClass().getClassLoader().getResource("numbers.txt").toURI()))
				.forEach(line -> {
					Assert.assertTrue(EnterpriseNumber.isValid(line));
				});
	}

	@Test
	public void isNotValidTest() throws IOException, URISyntaxException {
		Files.lines(Paths.get(getClass().getClassLoader().getResource("badnumbers.txt").toURI()))
				.forEach(line -> {
					Assert.assertFalse(String.format("line %s is valid", line), EnterpriseNumber.isValid(line));
				});
	}

}
