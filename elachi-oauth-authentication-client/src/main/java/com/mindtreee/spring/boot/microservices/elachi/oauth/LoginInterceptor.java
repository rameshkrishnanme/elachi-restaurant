/*
 * package com.mindtreee.spring.boot.microservices.elachi.oauth;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.InitializingBean; import
 * org.springframework.security.core.AuthenticationException; import
 * org.springframework.security.oauth2.common.ExpiringOAuth2RefreshToken; import
 * org.springframework.security.oauth2.common.OAuth2AccessToken; import
 * org.springframework.security.oauth2.common.OAuth2RefreshToken; import
 * org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
 * import org.springframework.security.oauth2.provider.OAuth2Authentication;
 * import org.springframework.security.oauth2.provider.TokenRequest; import
 * org.springframework.security.oauth2.provider.token.
 * AuthorizationServerTokenServices; import
 * org.springframework.security.oauth2.provider.token.
 * ResourceServerTokenServices; import
 * org.springframework.security.oauth2.provider.token.TokenStore; import
 * org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
 * import org.springframework.util.Assert; import
 * org.springframework.web.servlet.ModelAndView; import
 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 * 
 * public class LoginInterceptor extends HandlerInterceptorAdapter implements
 * AuthorizationServerTokenServices, ResourceServerTokenServices,
 * InitializingBean {
 * 
 * 
 * 
 * @Autowired TokenStore tokenStore;
 * 
 * private TokenStore tokenStore = new InMemoryTokenStore();
 * 
 * @Override public void afterPropertiesSet() throws Exception {
 * Assert.notNull(tokenStore, "tokenStore must be set"); }
 * 
 * public void setTokenStore(TokenStore tokenStore) { this.tokenStore =
 * tokenStore; }
 * 
 * @Override public void afterCompletion(HttpServletRequest request,
 * HttpServletResponse response, Object handler, Exception exception) throws
 * Exception { System.out.println("asdasdasdvhv......qw....................");
 * 
 * }
 * 
 * @Override public void postHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
 * throws Exception {
 * System.out.println("asdasdasdvhv..........234................");
 * 
 * }
 * 
 * @Override public boolean preHandle(HttpServletRequest request,
 * HttpServletResponse response, Object handler) throws Exception {
 * System.out.println("asdasdasdvhv..........................");
 * loadAuthentication(request.getParameter("token"));
 * 
 * List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
 * List<AccessProfile> accessProfile = accessProfileService.findAllById(1);
 * 
 * for (AccessProfile accessPfl: accessProfile) { list.add(new
 * SimpleGrantedAuthority(accessPfl.getAccess_profile())); }
 * 
 * return true;
 * 
 * HandlerMethod handlerMethod = (HandlerMethod) handler;
 * 
 * String emailAddress = request.getParameter("emailaddress"); String password =
 * request.getParameter("password");
 * 
 * if(StringUtils.isEmpty(emailAddress) ||
 * StringUtils.containsWhitespace(emailAddress) || StringUtils.isEmpty(password)
 * || StringUtils.containsWhitespace(password)) { throw new
 * Exception("Invalid User Id or Password. Please try again."); }
 * 
 * return true;
 * 
 * }
 * 
 * @Override public OAuth2Authentication loadAuthentication(String
 * accessTokenValue) throws AuthenticationException, InvalidTokenException {
 * 
 * OAuth2AccessToken accessToken = tokenStore.readAccessToken(accessTokenValue);
 * if (accessToken == null) { throw new
 * InvalidTokenException("Invalid access token: " + accessTokenValue); } else if
 * (accessToken.isExpired()) { tokenStore.removeAccessToken(accessToken); throw
 * new InvalidTokenException("Access token expired: " +
 * accessTokenValue.substring(0,200)); }
 * 
 * OAuth2Authentication result = tokenStore.readAuthentication(accessToken); if
 * (result == null) { // in case of race condition throw new
 * InvalidTokenException("Invalid access token: " + accessTokenValue); }
 * 
 * return result; }
 * 
 * @Override public OAuth2AccessToken readAccessToken(String accessToken) {
 * return tokenStore.readAccessToken(accessToken); }
 * 
 * protected boolean isExpired(OAuth2RefreshToken refreshToken) { if
 * (refreshToken instanceof ExpiringOAuth2RefreshToken) {
 * ExpiringOAuth2RefreshToken expiringToken = (ExpiringOAuth2RefreshToken)
 * refreshToken; return expiringToken.getExpiration() == null ||
 * System.currentTimeMillis() > expiringToken.getExpiration().getTime(); }
 * return false; }
 * 
 * @Override public OAuth2AccessToken createAccessToken(OAuth2Authentication
 * authentication) throws AuthenticationException { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public OAuth2AccessToken refreshAccessToken(String refreshToken,
 * TokenRequest tokenRequest) throws AuthenticationException { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public OAuth2AccessToken getAccessToken(OAuth2Authentication
 * authentication) { // TODO Auto-generated method stub return null; }
 * 
 * 
 * 
 * 
 * }
 */