package ge.tkach13.ItemScrollEffects.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerScope
import com.google.accompanist.pager.calculateCurrentOffsetForPage

@OptIn(ExperimentalPagerApi::class)
fun Modifier.cubeOutTransformer(currentPage: Int, pagerScope: PagerScope) =
    this.then(
        graphicsLayer {
            val pageOffset = pagerScope.calculateCurrentOffsetForPage(currentPage)
            cameraDistance = 20f
            transformOrigin =
                TransformOrigin(if (pageOffset > 0f) 1f else 0f, 0.5f)
            rotationY = -90f * pageOffset
        }
    )


