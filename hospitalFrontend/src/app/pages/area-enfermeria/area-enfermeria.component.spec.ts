import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AreaEnfermeriaComponent } from './area-enfermeria.component';

describe('AreaEnfermeriaComponent', () => {
  let component: AreaEnfermeriaComponent;
  let fixture: ComponentFixture<AreaEnfermeriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AreaEnfermeriaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AreaEnfermeriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
