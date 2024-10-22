package com.unittesting.android

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


class CarViewModelTestMockito {

    private val mockCarRepository: CarRepository =
        mock(CarRepository::class.java)  // manual way without annotation


    @Test
    fun fetchCarsByBrand() {
        val actualBrand = "bmw"
        val mercedes = Car("mercedes", 2019)
        val bmw = Car("bmw", 1980)
        val ford = Car("ford", 1995)
        val mercedesVintage = Car("mercedes", 1920)
        val jaguar = Car("jaguar", 1920)
        val phantom = Car("phantom", 1950)

        val carList1 = listOf(mercedes, bmw, ford, mercedesVintage)
        val carList2 = listOf(jaguar, phantom, ford, mercedesVintage)

        `when`(mockCarRepository.getCars()).thenReturn(carList2)

        val carViewModel = CarViewModel(mockCarRepository)

        val expectedCarList = listOf(Car(actualBrand, 1980))

        val result1 = carViewModel.fetchCarsByBrand(actualBrand)
        val result2 = carViewModel.fetchCarsByBrand(actualBrand)

        // this is used to check the expected result and the actual one are equal or not if not test case failed
        assertEquals(expectedCarList, result1)

        // if brand does not exist it would return empty list
        assertEquals(emptyList<Car>(), result2)

        assertEquals(0, result2.size)


        // we can test it by creating fake car repository, passing car list as a parameter to the repository and extend with main CarRepository class and override it and return the car list
//        For more information, please visit: https://blog.kotlin-academy.com/it-has-never-been-easier-to-understand-how-to-write-unit-tests-on-android-part-1-5ed1e5d8112b

    }
}


//Not working right now will check later
//@ExtendWith(MockitoExtension::class) // this is in the Junit 5 for Junit 4 skip this annotation & call 'MockitoAnnotations.initMocks(this)'
//@RunWith(MockitoJUnitRunner::class)
//class CarViewModelTestMockito {
//
//    @Mock
//    private lateinit var mockCarRepository: CarRepository
//
//    @InjectMocks
//    private lateinit var carViewModel: CarViewModel
//
//    @Before
//    fun setUp() {
//        MockitoAnnotations.openMocks(this) // Initialize mocks
//    }
//
//    @Test
//    fun fetchCarsByBrand() {
//        val mercedes = Car("mercedes", 2019)
//        val bmw = Car("bmw", 1980)
//        val ford = Car("ford", 1995)
//        val mercedesVintage = Car("mercedes", 1920)
//
//        val carList = listOf(mercedes, bmw, ford, mercedesVintage)
//        val expectedCarList = listOf(Car("bmw", 1980))
//
//        `when`(mockCarRepository.getCars()).thenReturn(carList)
//
//        // Act
//        val result = carViewModel.fetchCarsByBrand("bmw")
//
//        // Verify that getCars() was called
//        verify(mockCarRepository).getCars()
//
//        // Assert the result
////        assertEquals(expectedCarList, result)
//        assertEquals(expectedCarList, result)
//    }
//}
