package patientintake;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Date Time Converter Should")
@Tag("RunWithTagName")
class DateTimeConverterShould {

	@Nested
	class DateTime{
		@Test
		@DisplayName("convert Today String Correctly")
		void convertTodayStringCorrectly() {
			LocalDateTime result = DateTimeConverter.convertToDateTimeFromString("4/26/2021 6:31 pm",LocalDate.of(2021,04,26));
			assertEquals(result,LocalDateTime.of(2021,4,26,18,31),"Failed to convert todays String correctly");
		}
		
		@Test
		@DisplayName("throw Exception For Incorrect Pattern")
//		@Disabled
		void throwExceptionForIncorrectPattern() {
			assertThrows(RuntimeException.class,()->DateTimeConverter.convertToDateTimeFromString("2/24/2021 450 pm",LocalDate.of(2021,4,26)));
		}
	}

}
 