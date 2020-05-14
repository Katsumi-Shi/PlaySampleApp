@(userForm: Form[tables.T_User])


@views.html.main("一覧") {
<div class="container">
  <div class="row">
    <div class="col-lg-12">
    @helper.form(action = routes.UserController.create()) {
	  @helper.inputText(userForm("name"))
      @helper.inputText(userForm("schoolYear"))
      @helper.inputText(userForm("birthDay"))
      @helper.inputText(userForm("height"))
      @helper.inputText(userForm("food"))
 <input type="submit" class="btn btn-primary" value="SUBMIT" />
     }
     </div>
   </div>
</div>
