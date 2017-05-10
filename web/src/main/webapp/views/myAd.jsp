
<div  class="b-items__cars">
        <div ng-repeat="car in cars" class="b-items__cars-one wow zoomInUp" data-wow-delay="0.5s">
            <div class="b-items__cars-one-img">
                <img ng-src="${pageContext.request.contextPath}/{{car.imageList[0].imagePath}}" class="img-responsive"/>
            </div>
            <div class="b-items__cars-one-info">
                <form class="b-items__cars-one-info-header s-lineDownLeft">
                    <h2>{{car.mark}} {{car.model}} {{car.engineCapacity}}L</h2>
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/cars/edit/{{car.id}}">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i></a>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/profile/cars/{{car.id}}" aria-label="Delete">
                        <i class="fa fa-times" aria-hidden="true"></i>
                    </a> <br/>
                </form>
                <div class="row s-noRightMargin">
                    <div class="col-md-9 col-xs-12">
                        <p>{{car.description}}</p>
                        <div class="m-width row m-smallPadding">
                            <div class="col-xs-6">
                                <div class="row m-smallPadding">
                                    <div class="col-xs-6">
                                        <span class="b-items__cars-one-info-title">Year:</span>
                                        <span class="b-items__cars-one-info-title">Mileage:</span>
                                        <span class="b-items__cars-one-info-title">Transmission:</span>
                                    </div>
                                    <div class="col-xs-6">
                                        <span class="b-items__cars-one-info-value">{{car.year.getYear()}}</span>
                                        <span class="b-items__cars-one-info-value">{{car.milleage}} KM</span>
                                        <span class="b-items__cars-one-info-value">{{car.transmission}}</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-6">
                                <div class="row m-smallPadding">
                                    <div class="col-xs-4">
                                        <span class="b-items__cars-one-info-title">Fuel Type:</span>
                                        <span class="b-items__cars-one-info-title">Color:</span>
                                        <span class="b-items__cars-one-info-title">Doors:</span>
                                    </div>
                                    <div class="col-xs-8">
                                        <span class="b-items__cars-one-info-value">{{car.fuelType}}</span>
                                        <span class="b-items__cars-one-info-value">{{car.carColor}}</span>
                                        <span class="b-items__cars-one-info-value">{{car.doorsNumber}}-Doors</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-xs-12">
                        <div class="b-items__cars-one-info-price">
                            <div class="pull-right">
                                <h3>Price:</h3>
                                <h4>$ {{car.price}}</h4>
                            </div>
                            <a href="${pageContext.request.contextPath}/cars/{{car.id}}" class="btn m-btn">VIEW DETAILS<span
                                    class="fa fa-angle-right"></span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

</div>
