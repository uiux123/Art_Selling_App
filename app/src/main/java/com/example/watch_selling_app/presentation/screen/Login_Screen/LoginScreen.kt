package com.example.watch_selling_app.presentation.screen.Login_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.watch_selling_app.R
import com.example.watch_selling_app.domain.model.LoginContent
import com.example.watch_selling_app.domain.model.LoginFormData
import com.example.watch_selling_app.domain.model.LoginFormTextContent
import com.example.watch_selling_app.presentation.components.AnimatedImageButton
import com.example.watch_selling_app.presentation.components.BackIconButton
import com.example.watch_selling_app.presentation.components.FormField
import com.example.watch_selling_app.presentation.components.RememberMeCheckbox
import com.example.watch_selling_app.presentation.viewModel.LoginViewModel
import com.example.watch_selling_app.ui.theme.Dimens
import com.example.watch_selling_app.ui.theme.LocalCustomColors

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    content: LoginContent,
    formText: LoginFormTextContent,
    formData: LoginFormData,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onRememberMeChanged: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGoogleSignInClick: () -> Unit,
    onBackClick: () -> Unit,
    onLoginSuccess: () -> Unit

) {
    val scrollState = rememberScrollState()

    // put top image inside a Box
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        // top image placing
        Image(
            painter = painterResource(
                content
                    .backgroundImageResId
            ),
            contentDescription = content
                .backgroundImageDescriptionKey,
            modifier = modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop

        )



        Column(
            modifier = modifier
                .verticalScroll(scrollState)
                .fillMaxWidth(),
            horizontalAlignment = Alignment
                .CenterHorizontally
        )
        {

            Spacer(modifier = Modifier.height(Dimens.SpacingXXS))

            // form creation

            //email field
            FormField(
                value = formData.email,
                onValueChange = onEmailChanged,
                label = getSafeString(formText.emailLabelKey),
                placeholder = getSafeString(formText.emailPlaceholderKey),
                leadingIcon = formText.leadingIconMailResId,
            )

            //password field
            FormField(
                value = formData.password,
                onValueChange = onPasswordChanged,
                label = getSafeString(formText.passwordLabelKey),
                placeholder = getSafeString(formText.passwordPlaceholderKey),
                isPassword = true,
                leadingIcon = formText.leadingIconPassResId
            )

            // put remember me and forget password inside a ROW

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.SpacingM),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                // remember me check box
                RememberMeCheckbox(
                    checked = formData.rememberMe,
                    onCheckedChange = onRememberMeChanged,
                    label = getSafeString(formText.rememberMeKey)
                )

                // Spacer(modifier = Modifier.weight(Dimens.weightSame))

                // forget password
                Text(
                    text = getSafeString(formText.forgotPasswordKey),
                    style = MaterialTheme.typography.titleMedium,
                    color = LocalCustomColors.current.textColor,
                    modifier = Modifier
                        .clickable {/*handle clicking*/ }
                )

            }

            Spacer(modifier = modifier.height(Dimens.SpacingXS))

            // Login button
            AnimatedImageButton(
                imageResLight = content.loginButtonDarkResId,
                imageResDark = content.loginButtonLightResId,
                contentDescription = content.loginButtonDescriptionKey,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                onClick = { onLoginClick() }
            )

            // created register text inside a ROW

            Row(
                modifier = Modifier
                    .padding(top = Dimens.SpacingM)
                    .fillMaxWidth()
                    .clickable { onRegisterClick },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                //create texts
                Text(
                    text = getSafeString(
                        content.registerPromptKey,
                        fallback = stringResource(id = R.string.do_not_have_account)
                    ),
                    style = MaterialTheme.typography.labelMedium,
                    color = LocalCustomColors.current.textColor
                )

                Spacer(modifier = Modifier.width(Dimens.SpacingXXS))

                //register action key
                Text(
                    text = getSafeString(content.registerActionTextKey),
                    style = MaterialTheme.typography.titleSmall,
                    color = LocalCustomColors.current.textColor,
                    modifier = Modifier
                        .clickable { onRegisterClick() }
                )

            }

            Spacer(modifier = Modifier.height(Dimens.SpacingL))




        }


    }

}



@Composable
fun getSafeString(name: String, fallback: String = ""): String {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(name, "string", context.packageName)
    return if (id != 0) stringResource(id) else fallback
}







