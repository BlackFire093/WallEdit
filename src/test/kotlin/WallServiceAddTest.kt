import org.junit.Before
import org.junit.Test
import ru.netology.Likes
import ru.netology.Post
import ru.netology.WallService
import kotlin.test.assertEquals

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        assertEquals<Any>(true, WallService.add(Post(0, "Kotlin is cool", can_pin = true, can_delete = false, can_edit = true, post_type = "copy", 1, is_favorite = true, likes = Likes(100))))

    }

    @Test
    fun update(){
        WallService.add(Post(0, "Kotlin is cool", can_pin = true, can_delete = false, can_edit = true, post_type = "copy", 1, is_favorite = true, likes = Likes(100)))
        assertEquals(true, WallService.update(Post(1, "Kotlin is not difficult", can_pin = true, can_delete = false, can_edit = false, post_type = "post", is_pinned = 1, is_favorite = true, likes = Likes(100))))
    }

    @Test
    fun newUpdate(){
        WallService.add(Post(0, "Kotlin is cool", can_pin = true, can_delete = false, can_edit = true, post_type = "copy", 1, is_favorite = true, likes = Likes(100)))
        assertEquals(false, WallService.update(Post(5, "Kotlin is not difficult", can_pin = true, can_delete = false, can_edit = false, post_type = "post", is_pinned = 1, is_favorite = true, likes = Likes(100))))
    }
}


