
<div class="b-contacts__form">
    <header class="b-contacts__form-header s-lineDownLeft wow zoomInUp" data-wow-delay="0.5s">
        <h2 class="s-titleDet">Profile Settings</h2>
    </header>
    <div></div>
    <form action="${pageContext.request.contextPath}/profile/settings/{user.id}" method="post" class="s-form wow zoomInUp"
          data-wow-delay="0.5s">
        <input type="hidden" value="{{user.password}}" name="password" id="password" /> <br/>
        <input type="hidden" value="{{user.id}}" name="id" id="id" /> <br/>
        <input type="hidden"  value="{{user.login}}" name="login" id="login" /> <br/>
        <input type="hidden" value="{{user.email}}"  name="email" id="email" /><br/>
        <input type="hidden" value="{{user.role}}"  name="role" id="role" /><br/>
        <label>Your name <span>*</span></label>
        <input type="text" placeholder="YOUR NAME." value="{{user.name}}" name="name" id="name" /> <br/>
        <label>Your phone <span>*</span></label>
        <input type="text" pattern="\+375\([0-9]{2}\)[0-9]{3}-[0-9]{2}-[0-9]{2}"
               placeholder="YOUR PHONE." value="{{user.phone}}" name="phone" id="phone" /> <br/>

        <p style="color: red">${errorEmptyMessage}</p>
        <p style="color: red">${errorRegistrationMessage}</p>
        <button type="submit" onclick="validate(this.form)"  class="btn m-btn">SAVE<span class="fa fa-angle-right"></span></button>
    </form>
</div>
<script src="../js/registration.js"></script>

