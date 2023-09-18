import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaFarmaceuticaComponent } from './area-farmaceutica.component';

describe('AreaFarmaceuticaComponent', () => {
  let component: AreaFarmaceuticaComponent;
  let fixture: ComponentFixture<AreaFarmaceuticaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaFarmaceuticaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AreaFarmaceuticaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
