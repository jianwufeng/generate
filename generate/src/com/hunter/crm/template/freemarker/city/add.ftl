
<form name="addform" id="addform" action="/city/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "city.id" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.name" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.provinceId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.postcode" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	排序:
            <@spring.formInput  "city.order" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>